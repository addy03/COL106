public class home
{
    public static void main(String args[])
    {
        employee df = new employee("Aditya");
        df.AddEmployee("abc", "Aditya");
        df.AddEmployee("abc2", "Aditya");
        df.AddEmployee("abc3", "Aditya");
        df.AddEmployee("abc_1", "abc");
        df.AddEmployee("abc_2", "abc");
        df.AddEmployee("Aditya", "abc2");
        df.DeleteEmployee("abc","abc");
        df.LowestCommonBoss("abc","abc_1");
        df.PrintEmployees();

    }
}
