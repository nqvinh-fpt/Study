using System;
using AutomobileLibrary.BussinessObject;


namespace AutomobileLibrary.Respository
{
    public interface ICarRespository
    {
        IEnumerable<Car> GetCars();
        Car GetCarByID(int carid);
        void InsertCar(Car car);
        void DeleteCar(int carId);
        void UpdateCar(Car car);
    }
}
