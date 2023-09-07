public class EmpleadoPorHoras extends Empleado {
	private double salarioPorHora;
	private int horasTrabajadas;

	public double getSalarioPorHora() {
		return this.salarioPorHora;
	}

	public void setSalarioPorHora(double salarioPorHora) {
		this.salarioPorHora = salarioPorHora;
	}

	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public EmpleadoPorHoras(String nombre, double salarioPorHora, int horasTrabajadas) {
		throw new UnsupportedOperationException();
	}

	public double calcularSalario() {
		return salarioPorHora * horasTrabajadas;
	}
}