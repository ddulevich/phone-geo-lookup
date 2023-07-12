import React, {useState} from 'react';
import axios from 'axios';

const App = () => {
    const [phoneNumber, setPhoneNumber] = useState('');
    const [countryList, setCountryList] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');

    const handlePhoneNumberChange = (e) => {
        setPhoneNumber(e.target.value);
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        setIsLoading(true);

        try {
            const response = await axios.get('/lookup', {params: {phone: phoneNumber}});
            setCountryList(response.data);
            setErrorMessage('');
        } catch (error) {
            setCountryList([]);
            setErrorMessage(error.response.data.message);
            console.log(error);
        }

        setIsLoading(false);
    };

    return (
        <div className="container">
            <div className="content">
                <h1>Введите номер телефона</h1>
                <form onSubmit={handleSubmit}>
                    <input type="tel" value={phoneNumber} onChange={handlePhoneNumberChange}
                           placeholder="Введите номер телефона" required/>
                    <button type="submit">Отправить</button>
                </form>
                {errorMessage && <p className="error-message">{errorMessage}</p>}
                <div className="response">
                    {isLoading ? (
                        <p>Загрузка...</p>
                    ) : (
                        <ul>
                            {countryList.map((country) => (
                                <li key={country}>{country}</li>
                            ))}
                        </ul>
                    )}
                </div>
            </div>
        </div>
    );
};
export default App;