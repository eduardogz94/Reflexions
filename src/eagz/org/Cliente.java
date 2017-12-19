package eagz.org;

public class Cliente {
	
	@ColumnAn(name="Id", primaryK=true)
	private int id;
	
	@ColumnAn(name="Nombre", primaryK=false)
	private String name;
	
	@ColumnAn(name="Apellido", primaryK=false)
	private String lastn;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLastn() {
			return lastn;
		}

		public void setLastn(String lastn) {
			this.lastn = lastn;
		}		


}

