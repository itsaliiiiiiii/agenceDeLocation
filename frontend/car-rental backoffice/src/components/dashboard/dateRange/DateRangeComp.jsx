import '../areaTop/AreaTop.scss'
import "react-date-range/dist/styles.css"; // main style file
import "react-date-range/dist/theme/default.css"; // theme css file
import { addDays } from "date-fns";
import { DateRange } from "react-date-range";
import { useState, useRef, useEffect } from "react";
function DateRangeComp() {
    const [state, setState] = useState([
        {
          startDate: new Date(),
          endDate: addDays(new Date(), 7),
          key: "selection",
        },
      ]);
    
      const [showDatePicker, setShowDatePicker] = useState(false);
      const dateRangeRef = useRef(null);
    
      const handleInputClick = () => {
        setShowDatePicker(true);
      };
    
      const handleClickOutside = (event) => {
        if (dateRangeRef.current && !dateRangeRef.current.contains(event.target)) {
          setShowDatePicker(false);
        }
      };
    
      useEffect(() => {
        document.addEventListener("mousedown", handleClickOutside);
        return () => {
          document.removeEventListener("mousedown", handleClickOutside);
        };
      }, []);
    return (<section className="content-area-top">
        <div className="area-top-r">
            <div
                ref={dateRangeRef}
                className={`date-range-wrapper ${!showDatePicker ? "hide-date-range" : ""
                    }`}
                onClick={handleInputClick}
            >
                <DateRange
                    editableDateInputs={true}
                    onChange={(item) => setState([item.selection])}
                    moveRangeOnFirstSelection={false}
                    ranges={state}
                    showMonthAndYearPickers={false}
                />
            </div>
        </div>
    </section>)
}
export default DateRangeComp;