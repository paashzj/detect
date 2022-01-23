/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.paashzj.detect.service;

import com.github.paashzj.detect.command.KafkaCommand;
import com.github.paashzj.detect.module.DetectType;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Base64;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class KafkaDetectService {

    public void detect(DetectType detectType, KafkaCommand command) throws Exception {
        Properties props = new Properties();
        if (command.getBootstrapServers() != null) {
            props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, command.getBootstrapServers());
        } else {
            props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        }
        if (command.getSecurityProtocol() != null) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, command.getSecurityProtocol());
        }
        if (command.getSaslMechanism() != null) {
            props.put(SaslConfigs.SASL_MECHANISM, command.getSaslMechanism());
        }
        if (command.getSaslJaasConfig() != null) {
            props.put(SaslConfigs.SASL_JAAS_CONFIG, command.getSaslJaasConfig());
        }
        if (command.getSaslJaasConfigBase64() != null) {
            props.put(SaslConfigs.SASL_JAAS_CONFIG, Base64.getDecoder().decode(command.getSaslJaasConfigBase64()));
        }
        if (command.getSslEnabledProtocols() != null) {
            props.put(SslConfigs.SSL_ENABLED_PROTOCOLS_CONFIG, command.getSslEnabledProtocols());
        }
        if (command.getSslEndpointIdentificationAlgorithm() != null) {
            props.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG,
                    command.getSslEndpointIdentificationAlgorithm());
        }
        if (command.getSslTruststoreLocation() != null) {
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, command.getSslTruststoreLocation());
        }
        if (command.getSslTruststorePassword() != null) {
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, command.getSslTruststorePassword());
        }
        if (detectType.equals(DetectType.CONNECT_PRODUCER)) {
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            KafkaProducer<String, String> producer = new KafkaProducer<>(props);
            TimeUnit.SECONDS.sleep(10L);
            producer.close();
        }
    }

}
