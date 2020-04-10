package com.eef.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConsistentHash {
    private ConsistentHash() {}
    private static final Logger log = LoggerFactory.getLogger(ConsistentHash.class);

    public static int getConsistentHashBucket(String key, int bucketSize) {
        HashCode hashCode = Hashing.murmur3_32().hashBytes(key.getBytes());
        int bucket = Hashing.consistentHash(hashCode, bucketSize);
        return bucket;
    }

}
