package xbot.edubot;

import static org.junit.Assert.*;

import org.junit.Before;

import edu.wpi.first.wpilibj.MockDigitalInput;
import xbot.common.controls.sensors.MockJoystick;
import xbot.common.injection.BaseWPITest;
import xbot.edubot.operator_interface.OperatorInterface;
import xbot.edubot.subsystems.arm.ArmSubsystem;

public class BaseArmTest extends BaseWPITest {
	
	OperatorInterface oi;
	ArmSubsystem arms; 
	
	MockJoystick left;
	MockJoystick right;
	
	MockDigitalInput upperLimitSwitch;
	MockDigitalInput lowerLimitSwitch;
	
	
	@Before
	public void setUp (){
		super.setUp();
		oi = this.injector.getInstance(OperatorInterface.class);
		arms = this.injector.getInstance(ArmSubsystem.class);
		
		left = (MockJoystick)oi.leftJoystick;
		right = (MockJoystick)oi.rightJoystick;
		
		upperLimitSwitch = (MockDigitalInput)arms.upperLimitSwitch;
		lowerLimitSwitch = (MockDigitalInput)arms.lowerLimitSwitch;
	}
	
	public void triggerUpperLimitSwitch(){
		upperLimitSwitch.set_value(true);
	}
	
	public void triggerLowerLimitSwitch(){
		lowerLimitSwitch.set_value(true);
	}
	
	public void assertArmSpeed(double speed){
		assertEquals(speed, this.mockRobotIO.getPWM(5),0.001);
	}
	
	public void assertArmSpeed (double speed, String message){
		assertEquals(message, speed, this.mockRobotIO.getPWM(5),0.001);
	}

}
