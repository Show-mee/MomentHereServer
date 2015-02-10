package momenthere.trackmap;

public class test {
	public test(){}
	
	
	public static void main(String[] args){
		String msg = "";
		JsonService2 service =  new JsonService2();
		TrackmapNode tmn = service.getTrackmapNode();
		msg = JsonTools2.createJsonString("TrackmapNode", tmn);
		System.out.println(msg);
	}
}
