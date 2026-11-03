$ErrorActionPreference = 'Stop'
$repo = Split-Path -Parent $PSScriptRoot
$resources = @{}
Get-ChildItem (Join-Path $repo 'app/src/main/res/values') -Filter '*.xml' | ForEach-Object {
    [xml]$document = Get-Content -LiteralPath $_.FullName -Raw
    foreach ($node in $document.resources.ChildNodes) {
        if ($node -is [System.Xml.XmlElement] -and $node.HasAttribute('name')) { $resources[$node.GetAttribute('name')] = $node }
    }
}
function Resolve-Resource([string]$Value) {
    if ($Value -match '^@(?:string|bool|integer)/(.+)$' -and $resources.ContainsKey($Matches[1])) { return $resources[$Matches[1]].InnerText }
    return $Value
}
function Read-Array([string]$Value) {
    if ($Value -match '^@array/(.+)$' -and $resources.ContainsKey($Matches[1])) {
        return @($resources[$Matches[1]].SelectNodes('item') | ForEach-Object { Resolve-Resource $_.InnerText })
    }
    return @()
}
$android = 'http://schemas.android.com/apk/res/android'
$items = @()
Get-ChildItem (Join-Path $repo 'app/src/main/res/xml') -Filter '*_preferences.xml' | ForEach-Object {
    [xml]$document = Get-Content -LiteralPath $_.FullName -Raw
    $manager = [System.Xml.XmlNamespaceManager]::new($document.NameTable)
    $manager.AddNamespace('android', $android)
    $group = $_.BaseName.Replace('_preferences', '')
    foreach ($node in $document.SelectNodes('//*[@android:key]', $manager)) {
        $default = Resolve-Resource $node.GetAttribute('defaultValue', $android)
        $type = $node.LocalName.Split('.')[-1]
        $defaultValue = if ($type -match 'Switch|CheckBox') { $default -eq 'true' } else { $default }
        $items += [ordered]@{ group=$group; key=$node.GetAttribute('key',$android); title=(Resolve-Resource $node.GetAttribute('title',$android)); summary=(Resolve-Resource $node.GetAttribute('summary',$android)); type=$type; default=$defaultValue; entries=@(Read-Array $node.GetAttribute('entries',$android)); values=@(Read-Array $node.GetAttribute('entryValues',$android)); inputType=$node.GetAttribute('inputType',$android); dependency=$node.GetAttribute('dependency',$android) }
    }
}
$destination = Join-Path $repo 'windows/desktop/assets/settings.json'
$items | ConvertTo-Json -Depth 10 | Set-Content -LiteralPath $destination -Encoding utf8
Write-Output "Synchronized $($items.Count) Android settings to $destination"
