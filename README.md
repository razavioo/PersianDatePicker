# PersianDatePicker

[ ![Download](https://api.bintray.com/packages/emadrazavi/PersianDatePicker/dev.emad.persiandatepicker/images/download.svg?version=1.0.1) ](https://bintray.com/emadrazavi/PersianDatePicker/dev.emad.persiandatepicker/1.0.1/link)

This library is a Persian date picker with huge customization options.
My initial idea for creating this library was to build it to be used for a lot of different UI conditions.


## Customizations

Views of this class can be changed directly, according to your UI needs. The library is dependent on this great [NumberPicker](https://github.com/ShawnLin013/NumberPicker) library.
So you can play with each of these library's features except for **setOnValueChangedListener()**, which is directly used in our library.

## Special thanks

Thanks for Shawn with his great work in [NumberPicker](https://github.com/ShawnLin013/NumberPicker), which is beyond my imagination.
The UI of this library is dependent on his module.

Thanks for the amazing work of Saman Zamani for creating the [PersianDate](https://github.com/samanzamani/PersianDate), which this class is built upon it.
His work made creating this library so easy.

## Gradle

Add the dependency in your `build.gradle`

```gradle
buildscript {
    repositories {
        jcenter()
    }
}

dependencies {
    implementation 'com.shawnlin:number-picker:2.4.11'
    implementation 'dev.emad:persiandatepicker:1.0.1'
}
```

## Usage
After adding these two dependencies, sync your project and start using the View as below.

```Xml
<com.razavioo.persiandatepicker.PersianDatePicker
        android:id="@+id/persianDatePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```

As you can see, this class does not have any custom XML attributes because that will make the view less customizable.
If you need to change the UI parameter, you can get each of the inner view elements programmatically.

The methods for grabbing Views that you can change it is as follows.

| Method                  | Return Value | Description
| ----------------------- | ------------ | --------------------------------------|
| getYearNumberPicker()   | NumberPicker | get picker for year
| getMonthNumberPicker()  | NumberPicker | get picker for month
| getDayNumberPicker()    | NumberPicker | get picker for day
| getYearTitleTextView()  | TextView     | get TextView for title of year picker
| getMonthTitleTextView() | TextView     | get TextView for title of month picker
| getDayTitleTextView()   | TextView     | get TextView for title of day picker

 The **NumberPicker** is the view of the custom number picker.
 
 We have a method to choose whether you want to show month values as digits or strings.
 Digits are the number of the month, and the string is the name of the month.
 
| Method                               | Description
| ------------------------------------- | --------|
| setMonthType((monthType: MonthType))  | set month value type (**MonthType.DIGIT** or **MonthType.STRING**)

For listening to changes in the picker, you can use the below method.
the interface hase three methods, **onYearChanged**, **onMonthChanged**, **onDayChanged**.

| Method                               | Description
| ------------------------------------- | --------|
| setListener(listener: Listener)  | set listener for year, month and day changes

## Implementation suggestion
As this clas needs to be customized based off of your special UI needs and conditions, 
I suggest that you create a class that extends the **PersianDatePicker** class and has initialized with all your special configurations. then use this class instead of the general class.
In the [sample](https://github.com/razavioo/PersianDatePicker/blob/master/app/src/main/java/com/razavioo/sample/MyPersianDatePicker.kt), I have created one and you can get the idea by watching it.

## License
The source code is licensed under the [apache2](LICENSE) license.
