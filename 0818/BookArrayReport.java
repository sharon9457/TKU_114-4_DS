class Book{
    private String bookname;
    private String booknumber;
    private int price;
    private int number;

     Book(String bookname,String booknumber,int price,int number){
        this.bookname = bookname;
        this.booknumber = booknumber;
        this.price = price;
        this.number =Math.max(0,number);

     }
     public String getbookname(){
        return bookname;
     }
     public double getprice(){
        return price;
     }
     public int getnumber(){
        return number;
     }
    
     public String toString(){
        return "書名:"+bookname+"書的編號:"+booknumber+"價錢:"+price+"數量:"+number;
     }
}
public class BookArrayReport {
    public static void main(String[] args){
        Book[] book={
            new Book("獵人","001",100,500),
            new Book("進擊的巨人","002",110,2),
            new Book("二哈與他的白貓師尊","003",500,50),
            new Book("哈利波特","004",600,300),
        };
        for(int x =0;x<book.length;x++){
            System.out.println("所有書籍");
            System.out.println(book[x]);
        }
        double totalprice = 0;
        for(int x = 0;x<book.length;x++){
         totalprice +=( book[x].getprice() * book[x].getnumber());
    }
    System.out.print("庫存總價值:"+totalprice);

    Book heighBook = book[0];
    for(int x = 0 ;x<book.length;x++){
        if(book[x].getprice()>heighBook.getprice()){
            heighBook = book[x];
        }
    }
    System.out.println("最貴的書:"+heighBook.getbookname()+"價格"+heighBook.getprice());

    for(int x =0;x<book.length;x++){
        if(book[x].getnumber() <= 3){
            System.out.println(book[x].getbookname()+",剩餘數量:"+book[x].getnumber());
        }
    }
}}
