import { ConfigProvider, DatePicker } from 'antd'
import ruRU from 'antd/locale/ru_RU'

export const App = () => {

    return (
        <ConfigProvider locale={ruRU}>
            <h1 className="text-4xl text-purple-500">Hello</h1>
            <DatePicker/>
        </ConfigProvider>
    )
}
