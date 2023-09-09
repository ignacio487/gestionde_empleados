public class EmpleadoAsalariado extends Empleado {
	public EmpleadoAsalariado(String nombre, String salarioBase) {
		super(nombre, String.valueOf(salarioBase));
	}
	public String getTipo() {
		return "Empleado Asalariado";
	}

	public String calcularSalario() {
		double salario = Double.parseDouble(getSalarioBase());
		return String.format("%.2f", salario);
	}
}