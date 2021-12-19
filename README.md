# CoffeeIT

![Welcome Screen](WelcomeActivity.png)
![Choose your style](StyleFragment.png)
![Choose your size](SizeFragment.png)
![Overview of order](OverviewFragment.png)

Summary:
- the app uses Retrofit to fetch data from the API
- there are two Activities
- The main Activity contins Fragments for the selecting a style, selecting a size, and selection overview
- navigation between the Fragments is done via Jetpack navigation
- there is View Binding and Data Binding
- MVVM is used. a shared ViewModel is used to share the data between Fragments. the ViewModel stores the coffee data retrieved from the api as well as the selections made by the user

Some things that still need to be done:
- change theme/styles
- font (Avenir Next)
- icons
- responsive design - make sure the ui doesn't break on different screens and orientations
- url is hardcoded, change this so that device id is passed into url
- automated testing
- the extras screen
