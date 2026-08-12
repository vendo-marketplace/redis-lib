# redis-lib

## Overview
`redis-lib` is a shared library for the Vendo ecosystem that provides common Redis-related building blocks used across microservices (`auth-service`, `product-service`, API gateway, `aws-service`). It centralizes key-prefix classes for namespacing stored data and Redis-related exceptions, ensuring consistent and collision-free key management across the platform.

## Features

* Classes/constants for Redis key prefixes, used to namespace data per domain and avoid key collisions between services
* Exceptions dedicated to Redis-related error scenarios (e.g. serialization failures, missing keys, connection issues)
* Consistent key-building conventions shared across all services that interact with Redis
* Easy integration into any module of the Vendo ecosystem via a Maven dependency

## Installation
Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.vendo-marketplace-be</groupId>
    <artifactId>redis-lib</artifactId>
    <version>latest-version</version>
    <packaging>jar</packaging>
</dependency>
```

## Usage
Once the dependency is added, the prefix classes and exceptions from `redis-lib` become available for direct import in any module of the project.

Example:

```java
import com.vendo.redis_lib.prefix.PrefixProperties;
import com.vendo.redis_lib.exception.CodeExpiredException;

// Example usage

PrefixProperties prop = new PrefixProperties().buildPrefix("code");
String codeValue = redisTemplate.opsForValue().get(prop); 

if (codeValue == null) {     
    throw new CodeExpiredException("Code value expired or not found for user " + userId);
}
```

## Requirements

* Java 17

## Notes
This library is intended solely for internal use within the Vendo ecosystem (`com.vendo`). Key prefixes act as a shared namespacing contract across services — changing an existing prefix is a breaking change, since it can orphan already-stored data or cause key collisions between services.