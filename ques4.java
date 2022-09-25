class ques4{
    public static void main(String[] args){
        int population = 80000;
        int year = 0;                            //to store the time when current population = value in population variable
        while(population < 150000){
            population += (population * 5)/100;
            year++;
        }
        System.out.println(year);
    }
}