
public class ConstructorInjection
{
    public static void main(String[] args)
    {
        IRepository repository = new MongoDBRepository();
        DatabaseManager databaseManager = new DatabaseManager(repository);
        databaseManager.save();
    }
}

interface IRepository
{
    void save();
}

class MongoDBRepository implements IRepository
{
    @Override
    public void save()
    {
        System.out.println("MongoDB save() function is called.");
        // ... some logic
    }
}

class DatabaseManager
{
    private IRepository repository;

    // Constructor Injection
    public DatabaseManager(IRepository repository)
    {
        // guard clause
        if(repository == null)
            throw new IllegalArgumentException("repository could not found!");

        this.repository = repository;
    }

    public void save()
    {
        this.repository.save();
    }
}