/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.shaded.okio

import com.squareup.wire.shaded.okio.internal.commonClose
import com.squareup.wire.shaded.okio.internal.commonExhausted
import com.squareup.wire.shaded.okio.internal.commonIndexOf
import com.squareup.wire.shaded.okio.internal.commonIndexOfElement
import com.squareup.wire.shaded.okio.internal.commonPeek
import com.squareup.wire.shaded.okio.internal.commonRangeEquals
import com.squareup.wire.shaded.okio.internal.commonRead
import com.squareup.wire.shaded.okio.internal.commonReadAll
import com.squareup.wire.shaded.okio.internal.commonReadByte
import com.squareup.wire.shaded.okio.internal.commonReadByteArray
import com.squareup.wire.shaded.okio.internal.commonReadByteString
import com.squareup.wire.shaded.okio.internal.commonReadDecimalLong
import com.squareup.wire.shaded.okio.internal.commonReadFully
import com.squareup.wire.shaded.okio.internal.commonReadHexadecimalUnsignedLong
import com.squareup.wire.shaded.okio.internal.commonReadInt
import com.squareup.wire.shaded.okio.internal.commonReadIntLe
import com.squareup.wire.shaded.okio.internal.commonReadLong
import com.squareup.wire.shaded.okio.internal.commonReadLongLe
import com.squareup.wire.shaded.okio.internal.commonReadShort
import com.squareup.wire.shaded.okio.internal.commonReadShortLe
import com.squareup.wire.shaded.okio.internal.commonReadUtf8
import com.squareup.wire.shaded.okio.internal.commonReadUtf8CodePoint
import com.squareup.wire.shaded.okio.internal.commonReadUtf8Line
import com.squareup.wire.shaded.okio.internal.commonReadUtf8LineStrict
import com.squareup.wire.shaded.okio.internal.commonRequest
import com.squareup.wire.shaded.okio.internal.commonRequire
import com.squareup.wire.shaded.okio.internal.commonSelect
import com.squareup.wire.shaded.okio.internal.commonSkip
import com.squareup.wire.shaded.okio.internal.commonTimeout
import com.squareup.wire.shaded.okio.internal.commonToString

internal actual class RealBufferedSource actual constructor(
  actual val source: Source,
) : BufferedSource {
  actual var closed: Boolean = false
  override val buffer: Buffer = Buffer()

  override fun read(sink: Buffer, byteCount: Long): Long = commonRead(sink, byteCount)
  override fun exhausted(): Boolean = commonExhausted()
  override fun require(byteCount: Long): Unit = commonRequire(byteCount)
  override fun request(byteCount: Long): Boolean = commonRequest(byteCount)
  override fun readByte(): Byte = commonReadByte()
  override fun readByteString(): ByteString = commonReadByteString()
  override fun readByteString(byteCount: Long): ByteString = commonReadByteString(byteCount)
  override fun select(options: Options): Int = commonSelect(options)
  override fun <T : Any> select(options: TypedOptions<T>): T? = commonSelect(options)
  override fun readByteArray(): ByteArray = commonReadByteArray()
  override fun readByteArray(byteCount: Long): ByteArray = commonReadByteArray(byteCount)
  override fun read(sink: ByteArray): Int = read(sink, 0, sink.size)
  override fun readFully(sink: ByteArray): Unit = commonReadFully(sink)
  override fun read(sink: ByteArray, offset: Int, byteCount: Int): Int =
    commonRead(sink, offset, byteCount)

  override fun readFully(sink: Buffer, byteCount: Long): Unit = commonReadFully(sink, byteCount)
  override fun readAll(sink: Sink): Long = commonReadAll(sink)
  override fun readUtf8(): String = commonReadUtf8()
  override fun readUtf8(byteCount: Long): String = commonReadUtf8(byteCount)
  override fun readUtf8Line(): String? = commonReadUtf8Line()
  override fun readUtf8LineStrict() = readUtf8LineStrict(Long.MAX_VALUE)
  override fun readUtf8LineStrict(limit: Long): String = commonReadUtf8LineStrict(limit)
  override fun readUtf8CodePoint(): Int = commonReadUtf8CodePoint()
  override fun readShort(): Short = commonReadShort()
  override fun readShortLe(): Short = commonReadShortLe()
  override fun readInt(): Int = commonReadInt()
  override fun readIntLe(): Int = commonReadIntLe()
  override fun readLong(): Long = commonReadLong()
  override fun readLongLe(): Long = commonReadLongLe()
  override fun readDecimalLong(): Long = commonReadDecimalLong()
  override fun readHexadecimalUnsignedLong(): Long = commonReadHexadecimalUnsignedLong()
  override fun skip(byteCount: Long): Unit = commonSkip(byteCount)
  override fun indexOf(b: Byte): Long = indexOf(b, 0L, Long.MAX_VALUE)
  override fun indexOf(b: Byte, fromIndex: Long): Long = indexOf(b, fromIndex, Long.MAX_VALUE)
  override fun indexOf(b: Byte, fromIndex: Long, toIndex: Long): Long =
    commonIndexOf(b, fromIndex, toIndex)

  override fun indexOf(bytes: ByteString): Long = indexOf(bytes, 0L)
  override fun indexOf(bytes: ByteString, fromIndex: Long): Long = commonIndexOf(bytes, fromIndex)
  override fun indexOfElement(targetBytes: ByteString): Long = indexOfElement(targetBytes, 0L)
  override fun indexOfElement(targetBytes: ByteString, fromIndex: Long): Long =
    commonIndexOfElement(targetBytes, fromIndex)

  override fun rangeEquals(offset: Long, bytes: ByteString) = rangeEquals(
    offset,
    bytes,
    0,
    bytes.size,
  )

  override fun rangeEquals(
    offset: Long,
    bytes: ByteString,
    bytesOffset: Int,
    byteCount: Int,
  ): Boolean = commonRangeEquals(offset, bytes, bytesOffset, byteCount)

  override fun peek(): BufferedSource = commonPeek()
  override fun close(): Unit = commonClose()
  override fun timeout(): Timeout = commonTimeout()
  override fun toString(): String = commonToString()
}
