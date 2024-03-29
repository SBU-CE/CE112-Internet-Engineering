# مبانی با گولنگ ۳


+ مباحث: اسکنر، json و struct و تگ‌های struct 

در این سوال می‌خواهیم محتویات یک json را که در ورودی به برنامه‌ی ما داده می‌شود را بخوانیم و پردازش کنیم. 

#### توضیح در مورد ورودی
+ برای راحتی تست کردن، ورودی در قالب stdin به شما داده می‌شود اما برای شما الزامی نیست که با scanf و این خانواده بخوانیدش، می‌توانید مثل یک فایل با stdin برخورد کنید. 

+ دقت کنید که در اولین خط ورودی، تعداد خطوط json داده می‌شود.

در ورودی برنامه (stdin) یک json با فرمت زیر داده می‌شود. شما باید آن را بخوانید.
توجه کنید که لزوما به شکل فرمت‌شده و قشنگ مثل نمونه‌ی زیر نیست و ممکن است اصلا indent نداشته باشد یا در ۱ خط باشد بنابراین تلاش کنید به جای parse کردن، از مکانیسم‌های خود زبان مثل unmarshal استفاده کنید.

### ورودی نمونه ۱
```js
13
{
	"name" : "IE", 
	"id" : 123,
	"unit" : 3,
	"teacher" : "Dr Alvani",
	"TAs" :
		 [
			  "Roozbeh",
			  "MohammadHossein", 
			  "Reza",
			  "Parsa"
		]
}
```
همچنین دقت کنید که از پیش می‌دانیم که ورودی چند خط خواهد بود پس به راحتی می‌توان از Scanner استفاده نمود. 


پس از استخراج اطلاعات، می‌خواهیم اطلاعات مهم درس مربوطه را که اطلاعاتش را از ورودی گرفتیم چاپ کنیم. 

## خروجی نمونه‌ی ۱

```js
IE (3)
by Dr Alvani
```
عدد داخل پرانتز تعداد واحد‌های درس است و چیزی که بعد از by می‌آید اسم استاد درس است.


## تضمین
+ تضمین می‌شود که JSON ورودی دقیقا فیلد‌هایی مثل نمونه دارد و نه فیلدی اضافه‌تر و نه کمتر دارد. البته تعداد اعضای آرایه ممکن است هر عددی بین ۰ تا ۱۰۰ باشد. 
+ تضمین می‌شود که فیلد‌های unit و id عدد هستند.

## راهنمایی
+ برای خواندن ورودی از چنین ساختاری استفاده نکنید بلکه از اسکنر استفاده کنید چون quera ران‌تایم ارور می‌دهد.
```go
data, err := ioutil.ReadFile(os.Stdin.Name())
```
+ برای parse کردن داده، بهتر است از json unmarshal استفاده کند. به این منظور باید یک استراکت با فیلد‌هایی مشابه ساختار داده‌شده تعریف کنید. همچنین احتمالا لازم است از json tag برای استراکت استفاده کنید. قسمت "Using Struct Tags to Control Encoding" را در [این لینک](https://www.digitalocean.com/community/tutorials/how-to-use-struct-tags-in-go) ببینید.
+ برای تبدیل به رشته‌ی خروجی خوب است متد String() برای استراکت خود تعریف کنید. مثلا چنین تابعی:

```go
func (c Course) String() string {
    return fmt.Sprintf( /* TODO */)
}

```

## نمونه ورودی ۲

```js
1
{ "id" : 333, "unit" : 1, "name" : "computer lab", "teacher" : "Dr Motahhari" , "TAs" : [] }
```

## نمونه خروجی ۲

```
computer lab (1)
by Dr Motahhari
```
