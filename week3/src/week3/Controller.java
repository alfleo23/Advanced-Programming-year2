package week3;

public class Controller {

	public static void main(String[] args)
	{
		Student homeStud1 = new Student("Alan",-234);
		System.out.println(homeStud1.getName() + " number: " + homeStud1.getNum());
		if (homeStud1.errorChecking())
		{
			System.out.println(homeStud1.getNum() + " is an invalid student Number !!!");
		}
		
		
		Student homeStud2 = new Student("Jenny",2);
		System.out.println(homeStud2.getName() + " number: " + homeStud2.getNum());

		Student homeStud3 = new Student("Jane",0);
		System.out.println(homeStud3.getName() + " number: " + homeStud3.getNum());

		Student homeStud4 = new Student("James",10001);
		System.out.println(homeStud4.getName() + " number: " + homeStud4.getNum());

		OverseasStudent overStud1 = new OverseasStudent("Pierre",1235,"france");
		System.out.print(overStud1.getName() + " number: " + overStud1.getNum() + " ");
		System.out.println("Country: " + overStud1.getCountry());
		if (overStud1.checkCountry())
		{
			System.out.println(overStud1.getCountry() + " is an invalid country");
		}

		OverseasStudent overStud2 = new OverseasStudent("Klaus",1234,"Germany");
		System.out.print(overStud2.getName() + " number: " + overStud2.getNum() + " ");
		System.out.println("Country: " + overStud2.getCountry());

	}

}
