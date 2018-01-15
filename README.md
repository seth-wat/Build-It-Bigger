# Gradle for Android and Java
Utilize Gradle to create a modular and multi flavor app.

## Features
* Java library for supplying jokes
* Android library with an activity that displays jokes passed to it as intent extras.
* Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module    via an async task.
* Connected tests to verify that the async task is indeed loading jokes.
* Paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
