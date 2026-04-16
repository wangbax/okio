Okio
====

See the [project website][okio] for documentation and APIs.

Okio is a library that complements `java.io` and `java.nio` to make it much
easier to access, store, and process your data. It started as a component of
[OkHttp][1], the capable HTTP client included in Android. It's well-exercised
and ready to solve new problems.

Fork Changes
------------

This fork is based on Okio `3.9.1` and publishes artifacts under the
`io.github.wangbax` namespace.

It converts the Okio source package from `okio.*` to
`com.squareup.wire.shaded.okio.*` so projects that still carry `okio 1.x` can
use an Okio 3.x implementation without pulling in the original package name at
runtime.

- Published coordinates use the `io.github.wangbax` group instead of
  `com.squareup.okio`.
- Public API types now live under `com.squareup.wire.shaded.okio.*`.
- The current forked release is `3.9.1-shaded-1`.
- `okio-fakefilesystem` is published in the same fork for test usage.

How to Use
----------

Gradle JVM

```kotlin
dependencies {
  implementation("io.github.wangbax:okio-jvm:3.9.1-shaded-1")
}
```

Gradle Multiplatform

```kotlin
dependencies {
  implementation("io.github.wangbax:okio:3.9.1-shaded-1")
}
```

Fake File System

```kotlin
dependencies {
  testImplementation("io.github.wangbax:okio-fakefilesystem-jvm:3.9.1-shaded-1")
}
```

After switching dependencies, update imports from `okio.*` to
`com.squareup.wire.shaded.okio.*`. For example:

```kotlin
import com.squareup.wire.shaded.okio.ByteString
import com.squareup.wire.shaded.okio.FileSystem
import com.squareup.wire.shaded.okio.Path.Companion.toPath
```

This fork is intended for integration scenarios where the host application must
keep a legacy `okio 1.x` dependency while new code needs Okio 3.x behavior.

License
--------

    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
 [1]: https://github.com/square/okhttp
 [okio]: https://square.github.io/okio/
