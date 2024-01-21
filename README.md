<h1>My examle of API test automation project</h1>
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

Running of the CI/CD starts after every push or pull-request to master branch.<br>
The report itself is saved to the separate
branch [gh-pages](https://github.com/vladyslav-pustovalov/swagger-petstore/tree/gh-pages). <br>
Reports are in the folders named as a number of executing, the last one is with the last report.
</p>