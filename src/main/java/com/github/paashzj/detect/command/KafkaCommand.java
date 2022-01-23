/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.paashzj.detect.command;

import com.beust.jcommander.Parameter;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KafkaCommand {

    @Parameter(names = "--bootstrap-servers", description = "kafka bootstrap servers")
    private String bootstrapServers;

    @Parameter(names = "--security-protocol")
    private String securityProtocol;

    @Parameter(names = "--sasl-mechanism")
    private String saslMechanism;

    @Parameter(names = "--sasl-jaas-config")
    private String saslJaasConfig;

    @Parameter(names = "--sasl-jaas-config-base64")
    private String saslJaasConfigBase64;

    @Parameter(names = "--ssl-enabled-protocols")
    private String sslEnabledProtocols;

    @Parameter(names = "--ssl-endpoint-identification-algorithm")
    private String sslEndpointIdentificationAlgorithm;

    @Parameter(names = "--ssl-truststore-location")
    private String sslTruststoreLocation;

    @Parameter(names = "--ssl-truststore-password")
    private String sslTruststorePassword;

    public KafkaCommand() {
    }
}
