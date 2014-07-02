dwhello
=======

Dropwizard Basic Getting Started "Hello World" With Integrated Swagger Support

This is a the basic ["Hello World" application](https://dropwizard.github.io/dropwizard/getting-started.html) that utilizes the [Dropwizard](https://dropwizard.github.io/dropwizard/) framework. It has been further augmented to include [Swagger's Dropwizard Quickstart](https://github.com/wordnik/swagger-core/wiki/JavaDropwizard-Quickstart) updated to support Dropwizard 0.7

To clone, complie from source, and run it:

    $ git clone https://github.com/LigoSphere/dwhello.git
    $ cd dwhello
    $ mvn package
    $ ./dwhello.sh

This all assumes you have Java 1.7, git 1.9, and Maven 3.0 all installed and working properly on Ubuntu 14.04.  It has been tested with Dropwizard 0.7.0 and Swagger 1.3.6.

Once running, the following end-points will be available:

    http://localhost:8080/api-docs
    http://localhost:8080/api-docs/hello-world
    http://localhost:8080/hello-world
    http://localhost:8080/hello-world?name=Your+Name+Here

And, the admin system is available here:

    http://localhost:8081

To render a UI for the Swagger docs, you'll need [Swagger UI](https://github.com/wordnik/swagger-ui).
