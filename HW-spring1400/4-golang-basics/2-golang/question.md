# مبانی با گولنگ ۲

+ مباحث تحت پوشش: اسلایس، پکیج fmt و لوپ

در این سوال یک لیست از قابلیت‌های یک زبان برنامه‌نویسی به همراه اسم زبان به شما داده می شود، برنامه‌ی شما باید این لیست را در یک ساختار (مثلا اسلایس یا ..) نگهداری کند. 

سپس یک تعداد قابلیت دیگر داده می‌شود و شما باید مشخص کنید که زبان گفته شده هر کدام از این قابلیت‌ها را دارد یا نه. **دقت کنید که قابلیت ها را به شکل case insensetive بررسی کنید** یعنی بزرگ و کوچک بودن نوشته تاثیری در مقایسه شما نداشته باشد.


## ورودی 
در اولین خط ورودی، اسم زبان برنامه‌نویسی مورد نظر به همراه تعداد قابلیت‌هایش (m) می‌آید. سپس در m خط بعدی هر کدام یکی از قابلیت‌های زبان نوشته می‌شود.

در خط بعدی، عدد n می‌آید که تعداد کوئری‌های مورد نظر است. در ادامه نیز n رشته می‌آید که قابلیت‌هایی هستند که باید مشخص کنید در نمونه ورودی وجود دارند یا خیر.

## خروجی
در n خط خروجی، هر کدام یک `yes` یا `no` چاپ کنید.

## نمونه ورودی ۱ 

```
go 9
slice
map
for
for range
function
STRUCT
multiple return value
go routines
easy cross-compilation
5
generic
SLICE 
map
fUnction
struct
```


## نمونه خروجی ۱

```
no
yes
yes
yes
yes
```


## نمونه ورودی ۲
```
java 5
OOP 
generic 
collections 
lambda expressions
code once, run every where
3
oop
light-weight threads
multiple-inheritance
```

## نمونه خروجی ۲
```
yes
no
no
```

### توجه
+ تضمین می‌شود که نام زبان حتما تک کلمه‌ای است ولی همانطور که در مثال ها می‌بینید قابلیت ها می‌توانند چند کلمه‌ی باشند.
