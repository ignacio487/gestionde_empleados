public class EmpleadoPorHoras extends Empleado {
	private double salarioPorHora;
	private int horasTrabajadas;

	public EmpleadoPorHoras(String nombre, String salarioBase, int trabajadas, int horasTrabajadas) {
		super(nombre, salarioBase);
		this.horasTrabajadas = horasTrabajadas;
		this.salarioPorHora = salarioPorHora;
	}

	public String getTipo() {
		return "Empleado por Horas";
	}

	public String calcularSalario() {
		return String.valueOf(horasTrabajadas * salarioPorHora);
	}
}