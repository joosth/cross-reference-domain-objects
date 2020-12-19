class DemoController {

    def create () {
        A.withNewTransaction {
	    def a=new A(name:"A")
	    def b=new B(name:"B")
	    a.ref=b
	    b.ref=a
	    a.save(failOnError:true)   
	    b.save(failOnError:true)
        }
	def s=""
        A.findAll().each { a ->
           s= "a.id: ${a.id} a.name: ${a.name} a.ref.id: ${a.ref?.id} a.ref.name: ${a.ref?.name}\n"
	}
	B.findAll().each { b ->
           s+= "b.id: ${b.id} b.name: ${b.name} b.ref.id: ${b.ref?.id} b.ref.name: ${b.ref?.name}\n"
	}
        render(text:s,contentType: "text/plain", encoding: "UTF-8")

    }
		
    def list() {
	def s=""
        A.findAll().each { a ->
           s+="a.id: ${a.id} a.name: ${a.name} a.ref.id: ${a.ref?.id} a.ref.name: ${a.ref?.name}\n"
	}
	B.findAll().each { b ->
           s+="b.id: ${b.id} b.name: ${b.name} b.ref.id: ${b.ref?.id} b.ref.name: ${b.ref?.name}\n"
	}
        render(text: s,contentType: "text/plain", encoding: "UTF-8")

    }
} 

