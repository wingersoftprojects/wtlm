DROP PROCEDURE IF EXISTS sp_get_current_system_datetime;
DELIMITER //
CREATE PROCEDURE sp_get_current_system_datetime
(
	OUT out_current_system_datetime datetime 
)
BEGIN 
		set out_current_system_datetime=Now(); 
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_get_current_system_datetime2;
DELIMITER //
CREATE PROCEDURE sp_get_current_system_datetime2
()
BEGIN 
		set @cur_sys_datetime=Now(); 
		SELECT @cur_sys_datetime AS cur_sys_datetime;
END//
DELIMITER ;