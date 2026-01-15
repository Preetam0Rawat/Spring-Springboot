package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest{
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;

//	@Test       wihtout using the above annotaions
//	void findTheGreatesFromAllData_basicScenario() {
//		DataService dataServiceMock = mock(DataService.class);
//		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
//		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
//		int result = businessImpl.findTheGreatesFromAllData();
//		assertEquals(25, result);
//		}
	
	@Test
	void findTheGreatesFromAllData_basicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
		int result = businessImpl.findTheGreatesFromAllData();
		assertEquals(25, result);
		
		}
		
	
	@Test
	void findTheGreatesFromAllData_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		int result = businessImpl.findTheGreatesFromAllData();
		assertEquals(35, result);
		}
	
	
	@Test
	void findTheGreatesFromAllData_EmptArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int result = businessImpl.findTheGreatesFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
		}

}

