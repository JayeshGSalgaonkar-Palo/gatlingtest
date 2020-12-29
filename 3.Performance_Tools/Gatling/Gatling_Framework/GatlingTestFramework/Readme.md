Run Test
1. Intellij IDE
    1. Run "Engine Class"
    2. In the interactive "Run" - Choose a simulation number:
    3. Select run description (optional)
    4. Wait for "Process finished with exit code 0" to be displayed, wait for 10 sec for report.  
2. Command Line 
- mvn gatling:test (run all simulation in sequence)
- mvn gatling:test -Dgatling.simulationClass=performancetests.LoadTest (run only LoadTest simulation for e.g.)
    
Gatling cheat-sheet
-  https://gatling.io/docs/current/cheat-sheet/