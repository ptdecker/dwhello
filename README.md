dwhello
=======

Dropwizard Hello World (Todd's Version)

This is a the basic ["Hello World" application](https://dropwizard.github.io/dropwizard/getting-started.html) that utilizes the [Dropwizard](https://dropwizard.github.io/dropwizard/) framework.

To run it after compiling it from source:

    $ mkdir -p ~/code/dwhello
    $ cd ~/code/dwhello
    $ git init
    $ git remote add origin https://github.com/LigoSphere/dwhello.git
    $ git pull origin master
    $ mvn package
    $ ./dwhello.sh

This all assumes you have Java 1.7, git 1.9, and Maven 3.0 all installed and working properly on Ubuntu 14.04.

Once running, the following end-points will be available:

    http://localhost:8080/hello-world
    http://localhost:8080/hello-world?name=Your+Name+Here

And, the admin system is available here:

    http://localhost:8081
