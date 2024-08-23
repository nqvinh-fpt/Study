using AutomobileLibrary.BussinessObject;
using AutomobileLibrary.DataAccess;
namespace AutomobileLibrary.Respository
{
   public class CarRespository : ICarRespository
    {
        public Car GetCarByID(int carId) => CarDBContext.Instance.GetCarByID(carId);
        public IEnumerable<Car> GetCars() => CarDBContext.Instance.GetCarList();
        public void InsertCar(Car car) => CarDBContext.Instance.AddNew(car);
        public void DeleteCar(int carId) => CarDBContext.Instance.Remove(carId);
        public void UpdateCar(Car car) => CarDBContext.Instance.Update(car);
    }
    
}
