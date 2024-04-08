OtpViewCompose
===============

A beautiful material desinged otpView for your verification feature and you can customize it to match with your design.

<div align="center">
  <table>
    <tr>
      <td align="center">
        <img width="100%" src="demo/imageBasic.jpg" alt="screenshot 1">
      </td>
      <td align="center">
        <img width="100%" src="demo/imageCustomBlue.png" alt="screenshot 2">
      </td>
      <td align="center">
        <img width="100%" src="demo/imageCustomOrange.jpg" alt="screenshot 3">
      </td>
    </tr>
  </table>
</div>

Add Dependency
------
first add jitpack to your **dependencyResolutionManagement**

```
dependencyResolutionManagement{
    ...
    maven { url = uri("https://jitpack.io") }
}
```
then add the dependency
```
dependencies {
    ...
    implementation("com.github.mahdihassani-dev:OtpViewCompose:1.0")
}
```


Usage
------

*basic usage*
```kotlin
val otpText = remember {
        mutableStateOf("")
    }
    
OtpView(otpText = otpText.value) { it, isFilled ->
        otpText.value = it
        //isFilled is true when cells are filled with numbers
    }
```
*custom usage*
```kotlin
OtpView(
    otpText = otpText.value,
    borderFocusedColor = Color.Black, //color when focus on a cell
    textColor = Color.DarkGray, //text color
    modifier = Modifier.padding(bottom = 24.dp), //modifier for whole view
    otpCount = 6, //size of cells
    textStyle = MaterialTheme.typography.titleLarge //text style
        )
    { it, isFilled->
         otpText.value = it
    }
```


License
-------
    MIT License

    Copyright (c) 2024 mahdihassani-dev
    
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
    SOFTWARE.

