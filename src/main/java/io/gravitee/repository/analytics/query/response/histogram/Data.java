/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.repository.analytics.query.response.histogram;

import java.util.Map;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
public class Data {

    private final long timestamp;

    private final long count;

    private final Map<String, Long> data;

    public Data(long timestamp, long count) {
        this.timestamp = timestamp;
        this.count = count;
        this.data = null;
    }

    public Data(long timestamp, Map<String, Long> data) {
        this.timestamp = timestamp;
        this.count = 0;
        this.data = data;

    }

    public long timestamp() {
        return timestamp;
    }

    public long count() {
        return count;
    }

    public Map<String, Long> data() {
        return data;
    }
}
