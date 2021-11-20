# Issue description

After upgrading to Spring Boot 2.6.0 a test case started failing. It's fixable by using just one configuration extending from `WebSecurityConfigurerAdapter`, but the exact same configuration *did* work with Spring Boot 2.5.7.

# How to reproduce

Run the one test case in this project.
