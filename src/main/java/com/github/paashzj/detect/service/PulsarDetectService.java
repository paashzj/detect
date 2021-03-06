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

package com.github.paashzj.detect.service;

import com.github.paashzj.detect.command.PulsarCommand;
import com.github.paashzj.detect.module.DetectType;
import org.apache.pulsar.client.api.ClientBuilder;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;

import java.util.concurrent.TimeUnit;

public class PulsarDetectService {

    public void detect(DetectType detectType, PulsarCommand command) throws Exception {
        ClientBuilder clientBuilder = PulsarClient.builder();
        if (command.getServiceUrl() != null) {
            clientBuilder.serviceUrl(command.getServiceUrl());
        } else {
            clientBuilder.serviceUrl("pulsar://localhost:6650");
        }
        PulsarClient pulsarClient = clientBuilder.build();
        if (detectType.equals(DetectType.CONNECT_PRODUCER)) {
            Producer<byte[]> producer = pulsarClient.newProducer().topic(command.getTopic()).create();
            TimeUnit.SECONDS.sleep(10);
            producer.close();
        }
    }

}
