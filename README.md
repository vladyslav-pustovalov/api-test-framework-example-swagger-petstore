<h1>My example of API test automation project</h1>
<p>
<h3>Based on:</h3>

* Java 17
* Gradle
* JUnit5
* Rest-Assured
* AssertJ
* Allure
* GitHub Actions

</p>

<p>
<h3>The realization consists of:</h3>

* <a href="https://github.com/vladyslav-pustovalov/swagger-petstore/tree/master/src/main/java/io/swagger/petstore/api/pet/model" target="_blank">Models</a>, for deserealizing JSON into Java Objects;
* <a href="https://github.com/vladyslav-pustovalov/swagger-petstore/tree/master/src/main/java/io/swagger/petstore/api/pet/controller" target="_blank">Controllers</a>, for calling to API;
* <a href="https://github.com/vladyslav-pustovalov/swagger-petstore/tree/master/src/main/java/io/swagger/petstore/api/pet/assertion" target="_blank">Assertions</a>, for providing more some standard Assertions;
* <a href="https://github.com/vladyslav-pustovalov/swagger-petstore/tree/master/src/main/java/io/swagger/petstore/api/pet/util" target="_blank">Util classes</a>, for providing necessary settings in separate classes;
* <a href="https://github.com/vladyslav-pustovalov/swagger-petstore/tree/master/src/test/java/io/swagger/petstore/api/pet" target="_blank">Test classes</a>, where the tests itself exist;
* <a href="https://github.com/vladyslav-pustovalov/swagger-petstore/tree/master/.github/workflows" target="_blank">Git-Hub Actions workflow</a>, for setting automatically start test job on CI/CD on Git-Hub Actions, creating test-report, and saving the report to Git-Hub Pages;

</p>

<p>

The CI/CD runs after every push or pull request to the master branch.<br>
The report is saved to a separate
branch [gh-pages](https://github.com/vladyslav-pustovalov/swagger-petstore/tree/gh-pages). <br>
Reports are in the folders named as several executing, the last one [might be seen here](https://vladyslav-pustovalov.github.io/swagger-petstore/).
</p>
