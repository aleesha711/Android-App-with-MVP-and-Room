# MVP Android
You have heard about MVP, right? People have been talking about it. Some of you are using it, some of you aren’t and some of you left it for good.
MVP stands for Model-View-Presenter which is a UI design pattern. MVP pattern promotes separation of concern, each component just does its own thing. It keeps you focused.

* **Model:** it is an interface responsible for managing data. Model’s responsibilities include using APIs, caching data, managing databases and so on. The model can also be an interface that communicates with other modules in charge of these responsibilities. For example, if you are using the Repository pattern the model could be a Repository. If you are using the Clean architecture, instead, the Model could be an Interactor.
* **Presenter:** the presenter is the middle-man between model and view. All your presentation logic belongs to it. The presenter is responsible for querying the model and updating the view, reacting to user interactions updating the model.
* **View:** it is only responsible for presenting data in a way decided by the presenter. The view can be implemented by Activities, Fragments, any Android widget or anything that can do operations like showing a ProgressBar, updating a TextView, populating a RecyclerView and so on.

# Room Persistence Library

The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

The library helps you create a cache of your app's data on a device that's running your app. This cache, which serves as your app's single source of truth, allows users to view a consistent copy of key information within your app, regardless of whether users have an internet connection.

Reference : https://developer.android.com/topic/libraries/architecture/room