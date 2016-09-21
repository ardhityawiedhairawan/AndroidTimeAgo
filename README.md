Android Time Ago
==============================
Displaying time : 
1 Minutes Ago, 15 Minutes Ago, Yesterday, 2 days ago, 5 days ago, etc.

getRelativeTimeSpanString();
==============================
```
public String getTimeAgo(String dateInput) {
    String timeformat = dateInput;
    try {
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date convertedDate = dateFormat.parse(dateInput);
        CharSequence relavetime1 = DateUtils.getRelativeTimeSpanString(
                convertedDate.getTime(),
                now,
                DateUtils.SECOND_IN_MILLIS);
        timeformat = String.valueOf(relavetime1);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    return timeformat;
}
```

Result
--------------
<img src="screenshotapp.png" width="500"/>


Note : Edit time array before run this sample.


More Question ?
--------------
ardhityawiedhairawan@gmail.com  -
