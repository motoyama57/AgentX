/*
 * Copyright 2017 ZhangJiupeng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cc.agentx.client.net;

import io.netty.handler.traffic.GlobalTrafficShapingHandler;

import java.util.concurrent.Executors;

public class Status {
    public static final GlobalTrafficShapingHandler TRAFFIC_HANDLER
            = new GlobalTrafficShapingHandler(Executors.newScheduledThreadPool(1), 1000);

    public static void lookup() {
        new Thread(() -> {
            while (true) {
                System.out.println("READ: " + TRAFFIC_HANDLER.trafficCounter().cumulativeReadBytes() + " bytes");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}