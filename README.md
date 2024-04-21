# Dice-Project
Weather Forecast Summary

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
server.port = 8082
crediantials : 
rapid.key= c3887c193fmsh85f0993115be254p16f5eajsnf928e690b513
rapid.host= forecast9.p.rapidapi.com

auth.username = dice-mayank
auth.password = dice@123

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

curl --location 'http://localhost:8082/v1/weather/forecast-summary?city=Berlin' \
--header 'Authorization: Basic ZGljZS1tYXlhbms6ZGljZUAxMjM='


-----------------------------------------------------------------------------------------------------------------------------------------------------------------

curl --location 'http://localhost:8082/v1/weather/hourly-forecast?city=Delhi' \
--header 'Authorization: Basic ZGljZS1tYXlhbms6ZGljZUAxMjM='
