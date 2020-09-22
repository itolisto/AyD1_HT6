/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proceso;

import Objetos.Carrera;
import Objetos.Horario;
import Objetos.RegistroAcademico;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EDGARMAURICIOGOMEZFLORES_201114340 {

    private AsignarHorario asignarHorario;
    private Carrera carreraMock;
    private RegistroAcademico registroAcademicoMock;

    @Before
    public void setup() {
        carreraMock = mock(Carrera.class);
        registroAcademicoMock = mock(RegistroAcademico.class);
        asignarHorario = new AsignarHorario();
    }

    @Test
    public void test_invalid_carnet_anio_returns_false() {
        // Arrange
        when(registroAcademicoMock.getAnio()).thenReturn(-999);
        when(registroAcademicoMock.getCorrelativo()).thenReturn("14340");
        // Act
        boolean result = registroAcademicoMock.cheequearCarnet();
        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void test_invalid_carnet_length_returns_false() {
        // Arrange
        when(registroAcademicoMock.getAnio()).thenReturn(2011);
        when(registroAcademicoMock.getCorrelativo()).thenReturn("143407");
        // Act
        boolean result = registroAcademicoMock.cheequearCarnet();
        // Assert
        Assert.assertFalse(result);
    }

    @Test(expected = Exception.class)
    public void test_chequear_carnet_false_throws() throws Exception {
        // Arrange
        when(registroAcademicoMock.cheequearCarnet()).thenReturn(false);
        // Act
        asignarHorario.generarHorario(carreraMock, registroAcademicoMock);
        // Assert
        // Will throw
    }

    @Test
    public void test_generar_horario_sucessfull_returns_null() throws Exception {
        // Arrange
        when(registroAcademicoMock.cheequearCarnet()).thenReturn(true);
        when(carreraMock.procesarCarrera()).thenReturn(5);
        when(registroAcademicoMock.getAnio()).thenReturn(2011);
        // Act
        Horario result = asignarHorario.generarHorario(carreraMock, registroAcademicoMock);
        // Assert
        Assert.assertNull(result);
    }

    @Test
    public void test_invalid_codigo_carrera_doesnt_sets_codigo_horario() throws Exception {
        // Arrange
        when(registroAcademicoMock.cheequearCarnet()).thenReturn(true);
        when(carreraMock.procesarCarrera()).thenReturn(5);
        when(registroAcademicoMock.getAnio()).thenReturn(2011);
        // Act
        Horario result = asignarHorario.generarHorario(carreraMock, registroAcademicoMock);
        // Assert
        Assert.assertNull(result);
    }

    @Test
    public void test_valid_codigo_carrera_does_sets_codigo_horario() throws Exception {
        // Arrange
        when(registroAcademicoMock.cheequearCarnet()).thenReturn(true);
        when(carreraMock.procesarCarrera()).thenReturn(4);
        when(registroAcademicoMock.getAnio()).thenReturn(2011);
        // Act
        Horario result = asignarHorario.generarHorario(carreraMock, registroAcademicoMock);
        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getCodigoHorario(), 414);
    }

    @Test
    public void test_invalid_procesar_carrera_returns_null() throws Exception {
        // Arrange
        when(registroAcademicoMock.cheequearCarnet()).thenReturn(true);
        when(carreraMock.procesarCarrera()).thenReturn(5);
        when(registroAcademicoMock.getAnio()).thenReturn(2011);
        // Act
        Horario result = asignarHorario.generarHorario(carreraMock, registroAcademicoMock);
        // Assert
        Assert.assertNull(result);
    }

    @Test
    public void test_valid_procesar_carrera_does_sets_descripcion_horario() throws Exception {
        // Arrange
        when(registroAcademicoMock.cheequearCarnet()).thenReturn(true);
        when(carreraMock.procesarCarrera()).thenReturn(2);
        when(registroAcademicoMock.getAnio()).thenReturn(2011);
        // Act
        Horario result = asignarHorario.generarHorario(carreraMock, registroAcademicoMock);
        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getCodigoHorario(), 265);
        Assert.assertEquals(result.getDescripcion(), "Vespertino");
    }

}
