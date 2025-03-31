# Stopwatch

## About
This Java 17 library provides multiple stopwatch implementations for

- time measurement with good developer UX
- extendable classes as a base for your own use cases
- functions for human-readable time output and limitless formatting options
- flexible output with easy defaults for outputting to a logger or `System.out`

## Table of contents

- [Basic usage](#basic-usage)
- [License](#license)
- [Documentation](#documentation)
- [Artifacts](#artifacts)
- [Building](#building)
- [Contributing](#contributing)
- [Changelog](#changelog)

## Basic usage

### Simple time measurement using a static stopwatch

#### Static use, print elapsed time to System.out
```java
public static void  main(String[] args) throws InterruptedException {
    StaticStopwatch.start();
    Thread.sleep(1111); //let 1.111 seconds elapse

    //prints elapsed time to default output target (system out) in format HH:mm:ss.SSS
    //this prints "00:00:01.111"
    StaticStopwatch.stopAndPrint();
}
```

#### Static use, print elapsed time to logger
```java
    public static void  main(String[] args) throws InterruptedException {
        StaticStopwatch.start();
        Thread.sleep(1111); //let 1.111 seconds elapse
        
        //or maybe you want to use a Logger (e.g. SLF4J) instead?
        //(or any other method implementing java.util.function.Consumer<String>)
        Logger logger = LoggerFactory.getLogger(DefaultStopwatchExample.class);
        StaticStopwatch.stopAndPrint(logger::info);
        
        //you can apply individual formatting (see Apache DurationFormatUtils for syntax)
        //this prints "1 seconds and 111 milliseconds"
        StaticStopwatch.getElapsedTime().formatDuration("s' seconds and 'S' milliseconds'").println();
}
```

#### Instantiated stopwatch, custom output format
```java
	public static void  main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = new Stopwatch().start();
        Thread.sleep(1111); //let 1.111 seconds elapse
    
        //prints elapsed time to default output target (system out) in format HH:mm:ss.SSS
        //this prints "00:00:01.111"
        stopwatch.stop().getElapsedTime().println();
    
        //or maybe you want to use a Logger (e.g. SLF4J) instead?
        //(or any other method implementing java.util.function.Consumer<String>)
        Logger logger = LoggerFactory.getLogger(DefaultStopwatchExample.class);
        stopwatch.getElapsedTime().printTo(logger::info);
    
        //you can apply individual formatting (see Apache DurationFormatUtils for syntax)
        //this prints "1 seconds and 111 milliseconds"
        stopwatch.getElapsedTime().formatDuration("s' seconds and 'S' milliseconds'").println();
    
        //this prints "1.111 s"
        stopwatch.getElapsedTime().formatDuration("s'.'SSS' s'").println();
    }
```

## License

### ;TLDR

Do what you want with it, no attribution necessary.

### Zero-Clause BSD

Copyright (C) 2024 and onwards by contributors of this project.

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH
REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM
LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR
OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
PERFORMANCE OF THIS SOFTWARE.

Permission to use, copy, modify, and/or distribute this software for
any purpose with or without fee is hereby granted.

## Documentation

The classes and methods are documented with JavaDoc. To generate locally run
```shell
mvn javadoc:javadoc
```
To browse locally run
```shell
mvn site:run
```
and navigate to http://localhost:8080/apidocs/index.html

## Artifacts

### Maven

```xml
<dependency>
  <groupId>net.sasu.lib.time</groupId>
  <artifactId>stopwatch</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Other artifacts

Execute `mvn site:run` and navigate to http://localhost:8080/dependency-info.html

## Building

Generate JAR file with
```shell
mvn package
```

## Contributing

Contributions are welcome. If you find a bug or want to improve the library please open an issue before creating a pull request.

## Changelog

See [CHANGELOG.md](CHANGELOG.md)
