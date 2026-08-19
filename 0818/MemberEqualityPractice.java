import java.util.Objects;

class LibraryMember{
    private String memberId;
    private String name;
    private String email;

public LibraryMember(String meberId,String name , String email){
    this.memberId = memberId;
    this.name = name;
    this.email = email; 
}
@Override
public String toString(){
    return "會員ID"+memberId+"名字"+name+"email"+email;
}
@Override
public boolean equals(Object obj){
    if(this == obj){
        return true;
    }
    if(obj == null || getClass() != obj.getClass()){
        return false;
    }
    LibraryMember other = (LibraryMember)obj;
    return Objects.equals(this.memberId,other.memberId);
}
@Override
public int hashCode(){
    return Objects.hash(memberId);
}
}
public class MemberEqualityPractice {
    public static void main(String[] args){
        LibraryMember member1 = new LibraryMember("001","王大明","daminwang@gmail.com");
        LibraryMember member2 = new LibraryMember("002","李小美","shoumelee@gmail.com");
        System.out.println("會員1:"+member1);
        System.out.println("會員2:"+member2);
        System.out.println(member1 == member2);
        System.out.println(member1.equals(member2));

    }
}
