package com.github.andreyasadchy.xtra.util

import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.EOFException
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class WebSocketInputTest {
    @Test fun handshakeAndFirstFrameInOnePacketPreserveFrameBytes() {
        val frame = byteArrayOf(0x81.toByte(), 2, 'O'.code.toByte(), 'K'.code.toByte())
        val packet = "HTTP/1.1 101 Switching Protocols\r\nUpgrade: websocket\r\n\r\n".toByteArray() + frame
        val input = BufferedInputStream(ByteArrayInputStream(packet))
        assertEquals("HTTP/1.1 101 Switching Protocols", WebSocketInput.readHeaderLine(input))
        assertEquals("Upgrade: websocket", WebSocketInput.readHeaderLine(input))
        assertEquals("", WebSocketInput.readHeaderLine(input))
        assertArrayEquals(frame, WebSocketInput.readFully(input, frame.size))
    }

    @Test fun fragmentedNetworkReadsAreAssembled() {
        val input = object : ByteArrayInputStream(byteArrayOf(1, 2, 3, 4)) {
            override fun read(buffer: ByteArray, offset: Int, length: Int) = super.read(buffer, offset, minOf(length, 1))
        }
        assertArrayEquals(byteArrayOf(1, 2, 3, 4), WebSocketInput.readFully(input, 4))
    }

    @Test(expected = EOFException::class) fun incompleteFrameDoesNotDeliverZeroPaddedMessages() {
        WebSocketInput.readFully(ByteArrayInputStream(byteArrayOf(1)), 4)
    }

    @Test(expected = EOFException::class) fun incompleteHandshakeFails() {
        WebSocketInput.readHeaderLine(ByteArrayInputStream("HTTP/1.1".toByteArray()))
    }
}
