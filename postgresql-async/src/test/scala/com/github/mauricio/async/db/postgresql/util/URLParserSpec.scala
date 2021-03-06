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

package com.github.mauricio.async.db.postgresql.util

import org.specs2.mutable.Specification

class URLParserSpec extends Specification {

  "parser" should {

    "create a connection with the available fields" in {
      val connectionUri = "jdbc:postgresql://128.567.54.90:9987/my_database?username=john&password=doe"

      val configuration = URLParser.parse(connectionUri)

      configuration.username === "john"
      configuration.password === Some("doe")
      configuration.database === Some("my_database")
      configuration.host === "128.567.54.90"
      configuration.port === 9987
    }

    "create a connection from a heroku like URL" in {
      val connectionUri = "postgresql://john:doe@128.567.54.90:9987/my_database"

      val configuration = URLParser.parse(connectionUri)

      configuration.username === "john"
      configuration.password === Some("doe")
      configuration.database === Some("my_database")
      configuration.host === "128.567.54.90"
      configuration.port === 9987
    }

  }

}
