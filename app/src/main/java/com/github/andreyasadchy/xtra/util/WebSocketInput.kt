package com.github.andreyasadchy.xtra.util

import java.io.ByteArrayOutputStream
import java.io.EOFException
import java.io.InputStream

/** Reads HTTP headers and frames from the same buffered byte stream. */
internal object WebSocketInput {
    fun readHeaderLine(input: InputStream): String {
        val line = ByteArrayOutputStream()
        while (true) {
            val byte = input.read()
            if (byte == -1) throw EOFException("Truncated WebSocket handshake")
            if (byte == '\n'.code) return line.toString(Charsets.ISO_8859_1.name()).removeSuffix("\r")
            if (line.size() >= 16384) throw java.io.IOException("WebSocket header is too large")
            line.write(byte)
        }
    }

    fun readFully(input: InputStream, size: Int): ByteArray {
        val data = ByteArray(size)
        var offset = 0
        while (offset < size) {
            val count = input.read(data, offset, size - offset)
            if (count == -1) throw EOFException("Truncated WebSocket frame")
            offset += count
        }
        return data
    }
}
