# Simple-bin-validator

#Overview

API to validate credit card bin, based in spring boot.


#Build

You can build project tree from top of the repository.
```
  $ git clone git://github.com/jleber/simple-bin-validator.git
  $ cd simple-bin-validator
  $ mvn clean package
```
  
#Usage

You can run project with this:
```
  $ mvn spring-boot:run
```
  >NOTE: For simple tests you can make a GET request in http://localhost:8080/bin/check/5555555555555555
  this should return the following JSON > {"brand":"Mastercard","cvv":"3","length":"16"}
  
# License & Authors

Author: JLeber Labs (joao.leber91@gmail.com)

Copyright: 2015-2016, Jleber Labs, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
