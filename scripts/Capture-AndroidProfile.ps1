param(
    [string]$Adb = 'adb',
    [string]$Package = 'com.github.kristijan1001.xtra',
    [string]$Serial,
    [string]$OutputDirectory = 'profile'
)
$ErrorActionPreference = 'Stop'
$deviceArgs = if ($Serial) { @('-s', $Serial) } else { @() }
$outputPath = [System.IO.Path]::GetFullPath($OutputDirectory)
New-Item -ItemType Directory -Path $outputPath -Force | Out-Null
$stamp = Get-Date -Format 'yyyyMMdd-HHmmss'
function Capture([string]$Name, [string[]]$Command) {
    $result = & $Adb @deviceArgs shell @Command 2>&1
    if ($LASTEXITCODE -ne 0) { throw "ADB failed: $Name ($LASTEXITCODE)" }
    $result | Set-Content -LiteralPath (Join-Path $outputPath "$stamp-$Name.txt")
}
Capture 'battery' @('dumpsys', 'batterystats', '--charged', $Package)
Capture 'frames' @('dumpsys', 'gfxinfo', $Package)
Capture 'services' @('dumpsys', 'activity', 'services', $Package)
$cpu = & $Adb @deviceArgs shell dumpsys cpuinfo 2>&1
if ($LASTEXITCODE -ne 0) { throw 'ADB CPU snapshot failed' }
$cpu | Select-String -SimpleMatch $Package | Set-Content -LiteralPath (Join-Path $outputPath "$stamp-cpu.txt")
Write-Output "Saved cumulative diagnostics to $outputPath. Compare with a second snapshot under the same conditions."
