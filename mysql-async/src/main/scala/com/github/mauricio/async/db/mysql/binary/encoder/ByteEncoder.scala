/*
 * Copyright 2013 Maurício Linhares
 *
 * Maurício Linhares licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.github.mauricio.async.db.mysql.binary.encoder

import org.jboss.netty.buffer.ChannelBuffer
import com.github.mauricio.async.db.mysql.column.ColumnTypes
import com.github.mauricio.async.db.util.Log

object ByteEncoder extends BinaryEncoder {

  private final val log = Log.getByName(this.getClass.getName)

  def encode(value: Any, buffer: ChannelBuffer) {
    log.debug("Received value {}", value)
    buffer.writeByte(value.asInstanceOf[Byte])
    log.debug("wrote byte {}", buffer.getByte(buffer.writerIndex() - 1))
  }

  def encodesTo: Int = ColumnTypes.FIELD_TYPE_TINY
}
