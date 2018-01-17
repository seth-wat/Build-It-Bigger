## Summary  
The purpose of this project was to apply Gradle concepts to manage local and remote dependencies and build multiple app flavors. This app itself is simple and focuses on modularizing the build. A user requests a joke from the backend, it is pulled from the native Java library, then the Android library supplies an Activity to display the joke  

## Features
* Java library for supplying jokes.
* Android library with an activity that displays jokes passed to it as intent extras.
* Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Connected tests to verify that the async task is indeed loading jokes.

## Details  
* Java library can be found in: `/jokeLib`  
* Android library can be found in: `/androidJokeDisplay`  
* Cloud Endpoints: `/backend`

## Installation
* Select *backend* configuration and run, this deploys a local server to supply jokes.
* Select *app* configuration and install either `freeDebug` (ads)  or `paidDebug`.
* Tested on Android API 24.

## License
````
MIT License

Copyright (c) 2017 Seth Watkins

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.```

